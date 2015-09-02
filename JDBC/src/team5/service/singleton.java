package team5.test;

import team5.dao.Member;

public class singleton {
	private static boolean run = true; //
	private static boolean state = false; //로그인
	private static Member nowMember = new Member();//현재 로그인한 멤버 정보
	
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
