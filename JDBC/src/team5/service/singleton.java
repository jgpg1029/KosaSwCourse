package team5.test;

import team5.dao.Member;

public class singleton {
	private static boolean run = true; //
	private static boolean state = false; //�α���
	private static Member nowMember = new Member();//���� �α����� ��� ����
	
	public static boolean isRun() {
		return run;
	}
	public static void setRun(boolean run) {
		singleton.run = run;
	}
	public static boolean isState() {
		return state;
	}
	public static void setState(boolean state) {
		singleton.state = state;
	}
	public static Member getNowMember() {
		return nowMember;
	}
	public static void setNowMember(Member nowMember) {
		singleton.nowMember = nowMember;
	}
}
