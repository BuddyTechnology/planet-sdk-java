package im.facechat.test;

import im.facechat.planet.exp.PlanetException;
import im.facechat.planet.sdk.PlanetSDK;

public class TestSendMessage {

	public static void main(String[] args) {
		try{
			System.out.println(PlanetSDK.sendIM("hello","ni hao"));
		}catch(PlanetException e){
			e.printStackTrace();
		}
	}
}
