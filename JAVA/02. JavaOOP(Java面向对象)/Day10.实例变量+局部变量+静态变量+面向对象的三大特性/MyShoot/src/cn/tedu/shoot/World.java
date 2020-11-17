package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** �������� */
public class World extends JPanel {
	public static final int WIDTH = 400;  //���ڵĿ�
	public static final int HEIGHT = 700; //���ڵĸ�
	
	public static final int START = 0;     //����״̬
	public static final int RUNNING = 1;   //����״̬
	public static final int PAUSE = 2;     //��ͣ״̬
	public static final int GAME_OVER = 3; //��Ϸ����״̬
	private int state = START; //��ǰ״̬(Ĭ��Ϊ����״̬)
	
	private Sky sky = new Sky();    //���
	private Hero hero = new Hero(); //Ӣ�ۻ�
	private FlyingObject[] enemies = {}; //����(С�л�����л���С�۷�)����
	private Bullet[] bullets = {};  //�ӵ�����
	
	/** ���ɵ���(С�л�����л���С�۷�)���� */
	public FlyingObject nextOne() {
		Random rand = new Random(); //���������
		int type = rand.nextInt(20); //0��19
		if(type<5) { //0��4ʱ������С�۷����
			return new Bee();
		}else if(type<12) { //5��11ʱ������С�л�����
			return new Airplane();
		}else { //12��19ʱ�����ش�л�����
			return new BigAirplane();
		}
	}
	
	int enterIndex = 0; //�����볡����
	/** ����(С�л�����л���С�۷�)�볡 */
	public void enterAction() { //ÿ10������һ��
		enterIndex++; //ÿ10������1
		if(enterIndex%40==0) { //ÿ400(10*40)������һ��
			FlyingObject obj = nextOne(); //��ȡ���˶���
			enemies = Arrays.copyOf(enemies,enemies.length+1); //����
			enemies[enemies.length-1] = obj; //�����˶�����ӵ�enemies�����һ��Ԫ����
		}
	}
	
	int shootIndex = 0; //�ӵ��볡����
	/** �ӵ��볡 */
	public void shootAction() { //ÿ10������һ��
		shootIndex++; //ÿ10������1
		if(shootIndex%30==0) { //ÿ300(10*30)������һ��
			Bullet[] bs = hero.shoot(); //��ȡ�ӵ�����
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length); //����(bs�м���Ԫ�ؾ����󼸸�����)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //�����׷��
		}
	}
	
	/** �������ƶ� */
	public void stepAction() { //ÿ10������һ��
		sky.step(); //��ն�
		for(int i=0;i<enemies.length;i++) { //�������е���
			enemies[i].step(); //���˶�
		}
		for(int i=0;i<bullets.length;i++) { //���������ӵ�
			bullets[i].step(); //�ӵ���
		}
	}
	
	/** ɾ��Խ��ĵ��˺��ӵ�--�����ڴ�й© */
	public void outOfBoundsAction() { //ÿ10������һ��
		int index = 0; //1)��Խ����������±�  2)��Խ����˸���
		FlyingObject[] enemyLives = new FlyingObject[enemies.length]; //��Խ���������
		for(int i=0;i<enemies.length;i++) { //�������е���
			FlyingObject f = enemies[i]; //��ȡÿһ������
			if(!f.outOfBounds() && !f.isRemove()) { //��Խ�粢�ҷ�ɾ��״̬��
				enemyLives[index] = f; //����Խ�������ӵ���Խ�����������
				index++; //1)��Խ����������±���һ 2)��Խ����˸�����һ
			}
		}
		enemies = Arrays.copyOf(enemyLives, index); //����Խ��������鸴�Ƶ�enemies�У�enemies�ĳ���Ϊindex(�м�����Խ����򳤶�Ϊ��)
		
		index = 0; //����
		Bullet[] bulletLives = new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			if(!b.outOfBounds() && !b.isRemove()) {
				bulletLives[index] = b;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
		
	}
	
	int score = 0; //��ҵĵ÷�
	/** �ӵ�����˵���ײ */
	public void bulletBangAction() { //ÿ10������һ��
		for(int i=0;i<bullets.length;i++) { //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿ���ӵ�
			for(int j=0;j<enemies.length;j++) { //�������е���
				FlyingObject f = enemies[j]; //��ȡÿ������
				if(f.isLife() && b.isLife() && f.hit(b)) { //ײ����
					f.goDead(); //����ȥ��
					b.goDead(); //�ӵ�ȥ��
					if(f instanceof Enemy) { //����ײ�����ܵ÷�
						Enemy e = (Enemy)f; //����ײ����ǿתΪ�÷ֽӿ�
						score += e.getScore(); //��ҵ÷�
					}
					if(f instanceof Award) { //����ײ����Ϊ����
						Award a = (Award)f; //����ײ����ǿתΪ�����ӿ�
						int type = a.getAwardType(); //��ȡ��������
						switch(type) { //���ݽ�����������ȡ��ͬ�Ľ���
						case Award.DOUBLE_FIRE:   //����������Ϊ����ֵ
							hero.addDoubleFire(); //��Ӣ�ۻ�������
							break;
						case Award.LIFE:    //����������Ϊ��
							hero.addLife(); //��Ӣ�ۻ�����
							break;
						}
					}
					
				}
			}
		}
	}
	
	/** Ӣ�ۻ�����˵���ײ */
	public void heroBangAction() { //ÿ10������һ��
		for(int i=0;i<enemies.length;i++) { //�������е���
			FlyingObject f = enemies[i]; //��ȡÿ������
			if(f.isLife() && hero.isLife() && f.hit(hero)) { //ײ����
				f.goDead(); //����ȥ��
				hero.subtractLife(); //Ӣ�ۻ�����
				hero.clearDoubleFire(); //Ӣ�ۻ���ջ���ֵ
			}
		}
	}
	
	/** �����Ϸ���� */
	public void checkGameOverAction() { //ÿ10������һ��
		if(hero.getLife()<=0) { //��Ϸ������
			state = GAME_OVER;  //�޸ĵ�ǰ״̬Ϊ��Ϸ����״̬
		}
	}
	
	/** ������������� */
	public void action() {
		//����������
		MouseAdapter l = new MouseAdapter() {
			/** ��дmouseMoved()����ƶ��¼� */
			public void mouseMoved(MouseEvent e) {
				if(state==RUNNING) { //��������״̬��ִ��
					int x = e.getX(); //��ȡ����x����
					int y = e.getY(); //��ȡ����y����
					hero.moveTo(x, y); //Ӣ�ۻ���������ƶ�
				}
			}
			/** ��дmouseClicked()������¼� */
			public void mouseClicked(MouseEvent e) {
				switch(state) { //���ݵ�ǰ״̬����ͬ�Ĵ���
				case START:        //����״̬ʱ
					state=RUNNING; //�޸�Ϊ����״̬
					break;
				case GAME_OVER:  //��Ϸ����״̬ʱ
					score = 0;   //�����ֳ�(���ݹ���)
					sky = new Sky();
					hero = new Hero();
					enemies = new FlyingObject[0];
					bullets = new Bullet[0];
					state=START; //�޸�Ϊ����״̬
					break;
				}
			}
			/** ��дmouseExited()����Ƴ��¼� */
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING) { //����״̬ʱ
					state=PAUSE;     //�޸�Ϊ��ͣ״̬
				}
			}
			/** ��дmouseEntered()��������¼� */
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE) { //��ͣ״̬ʱ
					state=RUNNING; //�޸�Ϊ����״̬
				}
			}
		};
		this.addMouseListener(l); //�����������¼�
		this.addMouseMotionListener(l); //������껬���¼�
		
		Timer timer = new Timer(); //��ʱ������
		int intervel = 10; //��ʱ���(�Ժ���Ϊ��λ)
		timer.schedule(new TimerTask() {
			public void run() { //��ʱ�ɵ��Ǹ���(ÿ10������һ��)
				if(state==RUNNING) { //��������״̬��ִ��
					enterAction(); //����(С�л�����л���С�۷�)�볡
					shootAction(); //�ӵ��볡
					stepAction();  //�������ƶ�
					outOfBoundsAction(); //ɾ��Խ��ĵ��˺��ӵ�
					bulletBangAction();  //�ӵ�����˵���ײ
					heroBangAction();    //Ӣ�ۻ�����˵���ײ
					checkGameOverAction(); //�����Ϸ����
				}
				repaint();     //�ػ�(���µ���paint())
			}
		},intervel,intervel); //��ʱ�ƻ���
	}
	
	/** ��дpaint()�� */
	public void paint(Graphics g) {
		sky.paintObject(g);  //�����
		hero.paintObject(g); //��Ӣ�ۻ�
		for(int i=0;i<enemies.length;i++) { //�������е���
			enemies[i].paintObject(g); //������
		}
		for(int i=0;i<bullets.length;i++) { //���������ӵ�
			bullets[i].paintObject(g); //���ӵ�
		}
		
		g.drawString("SCORE: "+score,10,25); //����
		g.drawString("LIFE: "+hero.getLife(),10,45); //����
		
		switch(state) { //���ݵ�ǰ״̬����ͬ��ͼ
		case START: //����״̬ʱ������ͼ
			g.drawImage(Images.start,0,0,null);
			break;
		case PAUSE: //��ͣ״̬ʱ����ͣͼ
			g.drawImage(Images.pause,0,0,null);
			break;
		case GAME_OVER: //��Ϸ����״̬ʱ����Ϸ����ͼ
			g.drawImage(Images.gameover,0,0,null);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); //1)���ô��ڿɼ�  2)�������paint()    
		
		world.action(); //�������������
	}
	
}






























