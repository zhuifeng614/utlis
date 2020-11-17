package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** С�۷�:�Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award{
	private int xSpeed; //x�����ƶ��ٶ�
	private int ySpeed; //y�����ƶ��ٶ�
	private int awardType; //��������(0��1)
	/** ���췽�� */
	public Bee(){
		super(60,51);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0��1
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		x+=xSpeed; //x+(���������)
		y+=ySpeed; //y+(����)
		if(x<=0 || x>=World.WIDTH-this.width) { //��������
			xSpeed*=-1; //�л�����(�����������为)
		}
	}
	
	int index = 1;
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() { //ÿ10������һ��
		if(isLife()) {
			return Images.bees[0];
		}else if(isDead()) {
			BufferedImage img = Images.bees[index++];
			if(index==Images.bees.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** ��дgetAwardType()��ȡ�������� */
	public int getAwardType() {
		return awardType; //���ؽ�������
	}
	
}












