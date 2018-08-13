package kgc.book.object;

import java.util.*;

/**
 * @version2.0
 * @author Administrator 吃货联盟2.0 必达订餐系统
 */
public class Test5_ChiHuo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 定义数组存储信息，最多选定四份
		String[] names = new String[4];
		String[] dishMegs = new String[4];
		int[] times = new int[4];
		String[] addresses = new String[4];
		int[] states = new int[4];
		double[] sumPrices = new double[4];
		// 初始化第一条订单消息
		names[0] = "张晴";
		dishMegs[0] = "红烧带鱼2份";
		times[0] = 12;
		addresses[0] = "天成路207号";
		sumPrices[0] = 76.0;
		states[0] = 1;
		// 初始化第二条订单消息
		names[1] = "张晴";
		dishMegs[1] = "鱼香肉丝2份";
		times[1] = 18;
		addresses[1] = "天成路207号";
		sumPrices[1] = 45.0;
		states[1] = 0;
		// 定义菜单信息。
		String[] disNames = { "红烧带鱼", "鱼香肉丝", "时令鲜蔬" };
		double[] prices = { 38.0, 20.0, 10.0 };
		int[] praiseNums = new int[3];
		// 主体架构
		System.out.println("欢迎使用bi&da订餐系统");
		int num = 0;
		boolean is = true;
		do {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.print("请选择：");
			int con = input.nextInt();
			switch (con) {
			case 1:
//				实现我要订餐服务
				
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("》我要订餐");
				System.out.println("序号\t菜名\t单价\t点赞数");
//				遍历输出菜品信息
				for (int i = 0; i < disNames.length; i++) {
					String price = prices[i] + "￥";
					String praiseNum = (praiseNums[i] > 0) ? praiseNums[i]
							+ "赞" : "0";
					System.out.println((i + 1) + "\t" + disNames[i] + "\t"
							+ price + "\t" + praiseNum);
				}
//				标识餐袋状态
				boolean isAdd = false;
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;
//						直接给数组添加信息，也可以插入中间变量
						System.out.print("请输入订餐人姓名：");
						names[i] = input.next();
						System.out.print("请输入菜品编号：");
						int choose = input.nextInt();
						System.out.print("请输入您要的份数：");
						int number = input.nextInt();
						dishMegs[i] = disNames[choose - 1] + number + "份";
						double price = number * prices[choose - 1];
						double deliCharge = sumPrices[i] > 50 ? 0 : 5;
						sumPrices[i] = price + deliCharge;
						System.out.print("请输入送餐时间10-20间整点：");
						int time = input.nextInt();
//						判断配送时间是否符合要求，若不符合要求重新输入
						while (time < 10 || time > 20) {
							System.out.print("请输入正确送餐时间10-20间整点：");
							time = input.nextInt();
						}
						times[i] = time;
						System.out.print("请输入地址：");
						addresses[i] = input.next();
//						总结订餐信息并打印输出
						System.out.println("订餐成功!\n您定的是" + dishMegs[i]
								+ "\n送餐时间" + times[i] + "点\n餐费" + price
								+ "￥，送餐费" + deliCharge + "￥，总计" + sumPrices[i]
								+ "￥");
						break;
					}
				}
				if (!isAdd) {
					System.out.println("对不起，您的餐带已满！");
				}
				break;
			case 2:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("》查看餐袋");
//				实现查看餐袋功能
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
//					遍历输出餐袋信息
					if (names[i] != null) {
						String state = (states[i] == 0) ? "已预订" : "已完成";
						String time = times[i] + "点";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
				break;
			case 3:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("》签收订单");
//				实现签收订单功能
//				遍历输出餐袋以供参考
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = (states[i] == 0) ? "已预订" : "已完成";
						String time = times[i] + "点";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
				System.out.print("请选择要签收的订单：");
				int no = input.nextInt();
//				标识要签收餐品状态
				boolean isFind = false;
				for (int i = 0; i < names.length; i++) {
//					条件1
					if (states[i] == 0 && names[i] != null && no == i + 1) {
						states[i] = 1;
						System.out.println("订单已完成签收");
						isFind = true;
//						条件2
					} else if (states[i] == 1 && names[i] != null
							&& no == i + 1) {
						System.out.println("订单已签收，不可重复签收！");
						isFind = true;
					}
				}
//				不满足条件
				if (!isFind) {
					System.out.println("您选择的订单不存在！");
				}
				break;
			case 4:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("》删除订单");
				/*
				 * 实现删除订单功能
				 * 遍历输出菜单参考
				 * */
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = (states[i] == 0) ? "已预订" : "已完成";
						String time = times[i] + "点";
						System.out.println((i + 1) + "\t" + names[i] + "\t"
								+ dishMegs[i] + "\t\t" + time + "\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t"
								+ state);
					}
				}
//				标识状态
				boolean isDFind = false;
				System.out.print("请选择要删除的订单：");
				int no1 = input.nextInt();
				for (int i = 0; i < names.length; i++) {
//					条件1
					if (names[i] != null && states[i] == 1 && no1 == i + 1) {
						isDFind = true;
						for (int j = no1 - 1; j < names.length - 1; j++) {
//							移位覆盖删除
							names[j] = names[j + 1];
							dishMegs[j] = dishMegs[j + 1];
							times[j] = times[j + 1];
							addresses[j] = addresses[j + 1];
							sumPrices[j] = sumPrices[j + 1];
							states[j] = states[j + 1];
						}
//						末位清空
						names[names.length - 1] = null;
						dishMegs[names.length - 1] = null;
						times[names.length - 1] = 0;
						addresses[names.length - 1] = null;
						sumPrices[names.length - 1] = 0;
						states[names.length - 1] = 0;
						break;
//						条件2
					} else if (names[i] != null && states[i] == 0
							&& no1 == i + 1) {
						isDFind = true;
						System.out.println("您选择的订单未签收！");
						break;
					}
				}
//				不满足条件
				if (!isDFind) {
					System.out.println("您要删除的订单不存在！");
				}
				break;
			case 5:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("》我要点赞");
				/*实现我要点赞功能
				遍历输出菜单*/
				System.out.println("序号\t菜名\t单价\t点赞数");
				for (int i = 0; i < disNames.length; i++) {
					String price = prices[i] + "￥";
					String praiseNum = (praiseNums[i] > 0) ? praiseNums[i]
							+ "赞" : "0";
					System.out.println((i + 1) + "\t" + disNames[i] + "\t"
							+ price + "\t" + praiseNum);
				}
				System.out.print("输入要点赞菜品序号");
				int no2 = input.nextInt();
//				实现点赞数加一并赋值给数组存储
				praiseNums[no2 - 1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//				标记不返回
				is = false;
				System.out.println("退出系统");
				break;
			default:

				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				is = false;
				System.out.println("输入错误，退出系统");
				break;
			}
//			判断是否返回继续循环
			if (is) {
				System.out.print("输入0返回");
				num = input.nextInt();
			} else {
				break;
			}
		} while (num == 0);

		input.close();
	}
}
