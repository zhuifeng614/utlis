package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** �ӵ�:�Ƿ����� */
public class Bullet extends FlyingObject{
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public Bullet(int x,int y){
		super(8,20,x,y);
		speed = 3;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y-=speed; //y-(����)
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() {
		if(isLife()) {            //�����ŵ�
			return Images.bullet; //�򷵻�bulletͼƬ
		}else if(isDead()) { //�����˵�
			state = REMOVE;	 //�򽫵�ǰ״̬�޸�Ϊɾ��״̬
		}
		return null; //���˵ĺ�ɾ����״̬ʱ��������null
	}
	
	/** ��дoutOfBounds()�ж��ӵ��Ƿ�Խ�� */
	public boolean outOfBounds() {
		return this.y<=-this.height; //�ӵ���y<=�����ӵ��ĸߣ���ΪԽ����
	}
	
}














