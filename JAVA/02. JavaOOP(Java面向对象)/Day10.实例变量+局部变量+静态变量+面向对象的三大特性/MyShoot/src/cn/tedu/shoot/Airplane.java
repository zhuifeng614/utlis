package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** С�л�:�Ƿ����Ҳ�ܵ÷� */
public class Airplane extends FlyingObject implements Enemy {
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public Airplane(){
		super(48,50);
		speed = 2;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y+=speed; //y+(����)
	}
	
	int index = 1; //�±�
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() { //ÿ10������һ��
		if(isLife()) { //�����ŵ�
			return Images.airplanes[0]; //���ص�1��ͼƬ
		}else if(isDead()) { //�����˵�
			BufferedImage img = Images.airplanes[index++]; //���λ�ȡ��2�ŵ���5�ű���ͼ
			if(index==Images.airplanes.length) { //�������һ��ͼ��
				state = REMOVE; //����ǰ״̬�޸�ΪREMOVEɾ��
			}
			return img; //���ر���ͼ
		}
		return null; //ɾ��״̬ʱ������null
		/*
		 *                      index=1
		 * 10M img=airplanes[1] index=2                  ����airplanes[1]
		 * 20M img=airplanes[2] index=3                  ����airplanes[2]
		 * 30M img=airplanes[3] index=4                  ����airplanes[3]
		 * 40M img=airplanes[4] index=5(REMOVE) ����airplanes[4]
		 * 50M 
		 */
	}
	
	/** ��дgetScore()�÷� */
	public int getScore() {
		return 1; //���С�л�����ҵ�1��
	}
	
}












