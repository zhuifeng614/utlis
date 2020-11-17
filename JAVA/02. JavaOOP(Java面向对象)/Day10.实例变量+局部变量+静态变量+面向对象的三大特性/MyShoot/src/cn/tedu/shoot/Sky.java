package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** ���:�Ƿ����� */
public class Sky extends FlyingObject {
	private int speed; //�ƶ��ٶ�
	private int y1;    //��2��ͼ��y����
	/** ���췽�� */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** ��дstep()�ƶ� */
	public void step() {
		y+=speed;  //y+(����)
		y1+=speed; //y1+(����)
		if(y>=World.HEIGHT) { //y����������
			y=-World.HEIGHT;  //�޸�y��ֵΪ���Ĵ��ڵĸ�(�Ƶ�������ȥ)
		}
		if(y1>=World.HEIGHT) { //y1����������
			y1=-World.HEIGHT;  //�޸�y1��ֵΪ���Ĵ��ڵĸ�(�Ƶ�������ȥ)
		}
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage() {
		return Images.sky; //ֱ�ӷ���skyͼƬ����
	}
	
	/** ��дpaintObject()������ */
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
		g.drawImage(getImage(),x,y1,null);
	}
	
}














