package kgc.book.object;

import java.util.*;

/**
 * @version2.0
 * @author Administrator �Ի�����2.0 �شﶩ��ϵͳ
 */
public class Test5_ChiHuo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// ��������洢��Ϣ�����ѡ���ķ�
		String[] names = new String[4];
		String[] dishMegs = new String[4];
		int[] times = new int[4];
		String[] addresses = new String[4];
		int[] states = new int[4];
		double[] sumPrices = new double[4];
		// ��ʼ����һ��������Ϣ
		names[0] = "����";
		dishMegs[0] = "���մ���2��";
		times[0] = 12;
		addresses[0] = "���·207��";
		sumPrices[0] = 76.0;
		states[0] = 1;
		// ��ʼ���ڶ���������Ϣ
		names[1] = "����";
		dishMegs[1] = "������˿2��";
		times[1] = 18;
		addresses[1] = "���·207��";
		sumPrices[1] = 45.0;
		states[1] = 0;
		// ����˵���Ϣ��
		String[] disNames = { "���մ���", "������˿", "ʱ������" };
		double[] prices = { 38.0, 20.0, 10.0 };
		int[] praiseNums = new int[3];
		// ����ܹ�
		System.out.println("��ӭʹ��bi&da����ϵͳ");
		int num = 0;
		boolean is = true;
		do {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.print("��ѡ��");
			int con = input.nextInt();
			switch (con) {
			case 1:
//				ʵ����Ҫ���ͷ���
				
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("����Ҫ����");
				System.out.println("���\t����\t����\t������");
//				���������Ʒ��Ϣ
				for (int i = 0; i < disNames.length; i++) {
					String price = prices[i] + "��";
					String praiseNum = (praiseNums[i] > 0) ? praiseNums[i]
							+ "��" : "0";
					System.out.println((i + 1) + "\t" + disNames[i] + "\t"
							+ price + "\t" + praiseNum);
				}
//				��ʶ�ʹ�״̬
				boolean isAdd = false;
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;
//						ֱ�Ӹ����������Ϣ��Ҳ���Բ����м����
						System.out.print("�����붩����������");
						names[i] = input.next();
						System.out.print("�������Ʒ��ţ�");
						int choose = input.nextInt();
						System.out.print("��������Ҫ�ķ�����");
						int number = input.nextInt();
						dishMegs[i] = disNames[choose - 1] + number + "��";
						double price = number * prices[choose - 1];
						double deliCharge = sumPrices[i] > 50 ? 0 : 5;
						sumPrices[i] = price + deliCharge;
						System.out.print("�������Ͳ�ʱ��10-20�����㣺");
						int time = input.nextInt();
//						�ж�����ʱ���Ƿ����Ҫ����������Ҫ����������
						while (time < 10 || time > 20) {
							System.out.print("��������ȷ�Ͳ�ʱ��10-20�����㣺");
							time = input.nextInt();
						}
						times[i] = time;
						System.out.print("�������ַ��");
						addresses[i] = input.next();
//						�ܽᶩ����Ϣ����ӡ���
						System.out.println("���ͳɹ�!\n��������" + dishMegs[i]
								+ "\n�Ͳ�ʱ��" + times[i] + "��\n�ͷ�" + price
								+ "�����Ͳͷ�" + deliCharge + "�����ܼ�" + sumPrices[i]
								+ "��");
						break;
					}
				}
				if (!isAdd) {
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("���鿴�ʹ�");
//				ʵ�ֲ鿴�ʹ�����
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
//					��������ʹ���Ϣ
					if (names[i] != null) {
						String state = (states[i] == 0) ? "��Ԥ��" : "�����";
						String time = times[i] + "��";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
				break;
			case 3:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("��ǩ�ն���");
//				ʵ��ǩ�ն�������
//				��������ʹ��Թ��ο�
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = (states[i] == 0) ? "��Ԥ��" : "�����";
						String time = times[i] + "��";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
				System.out.print("��ѡ��Ҫǩ�յĶ�����");
				int no = input.nextInt();
//				��ʶҪǩ�ղ�Ʒ״̬
				boolean isFind = false;
				for (int i = 0; i < names.length; i++) {
//					����1
					if (states[i] == 0 && names[i] != null && no == i + 1) {
						states[i] = 1;
						System.out.println("���������ǩ��");
						isFind = true;
//						����2
					} else if (states[i] == 1 && names[i] != null
							&& no == i + 1) {
						System.out.println("������ǩ�գ������ظ�ǩ�գ�");
						isFind = true;
					}
				}
//				����������
				if (!isFind) {
					System.out.println("��ѡ��Ķ��������ڣ�");
				}
				break;
			case 4:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("��ɾ������");
				/*
				 * ʵ��ɾ����������
				 * ��������˵��ο�
				 * */
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = (states[i] == 0) ? "��Ԥ��" : "�����";
						String time = times[i] + "��";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
//				��ʶ״̬
				boolean isDFind = false;
				System.out.print("��ѡ��Ҫɾ���Ķ�����");
				int no1 = input.nextInt();
				for (int i = 0; i < names.length; i++) {
//					����1
					if (names[i] != null && states[i] == 1 && no1 == i + 1) {
						isDFind = true;
						for (int j = no1 - 1; j < names.length - 1; j++) {
//							��λ����ɾ��
							names[j] = names[j + 1];
							dishMegs[j] = dishMegs[j + 1];
							times[j] = times[j + 1];
							addresses[j] = addresses[j + 1];
							sumPrices[j] = sumPrices[j + 1];
							states[j] = states[j + 1];
						}
//						ĩλ���
						names[names.length - 1] = null;
						dishMegs[names.length - 1] = null;
						times[names.length - 1] = 0;
						addresses[names.length - 1] = null;
						sumPrices[names.length - 1] = 0;
						states[names.length - 1] = 0;
						break;
//						����2
					} else if (names[i] != null && states[i] == 0
							&& no1 == i + 1) {
						isDFind = true;
						System.out.println("��ѡ��Ķ���δǩ�գ�");
						break;
					}
				}
//				����������
				if (!isDFind) {
					System.out.println("��Ҫɾ���Ķ��������ڣ�");
				}
				break;
			case 5:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("����Ҫ����");
				/*ʵ����Ҫ���޹���
				��������˵�*/
				System.out.println("���\t����\t����\t������");
				for (int i = 0; i < disNames.length; i++) {
					String price = prices[i] + "��";
					String praiseNum = (praiseNums[i] > 0) ? praiseNums[i]
							+ "��" : "0";
					System.out.println((i + 1) + "\t" + disNames[i] + "\t"
							+ price + "\t" + praiseNum);
				}
				System.out.print("����Ҫ���޲�Ʒ���");
				int no2 = input.nextInt();
//				ʵ�ֵ�������һ����ֵ������洢
				praiseNums[no2 - 1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//				��ǲ�����
				is = false;
				System.out.println("�˳�ϵͳ");
				break;
			default:

				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				is = false;
				System.out.println("��������˳�ϵͳ");
				break;
			}
//			�ж��Ƿ񷵻ؼ���ѭ��
			if (is) {
				System.out.print("����0����");
				num = input.nextInt();
			} else {
				break;
			}
		} while (num == 0);

		input.close();
	}
}
