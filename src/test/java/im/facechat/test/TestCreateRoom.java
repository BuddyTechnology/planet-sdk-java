package im.facechat.test;

import im.facechat.planet.cons.Planets;
import im.facechat.planet.exp.PlanetException;
import im.facechat.planet.module.RoomPolicy;
import im.facechat.planet.sdk.PlanetSDK;

public class TestCreateRoom {

	public static void main(String[] args){
		try{
			RoomPolicy policy = new RoomPolicy();
			policy.setDisableP2P(true);
			policy.setMembers(new String[]{"token1","token2"});
			policy.setDisableP2P(true);
			policy.setQuality(Planets.RTC.Quality.HIGH);
			for(int index = 0;index <= 10;index++){
				System.out.println(PlanetSDK.createRoom(policy));
			}
		}catch(PlanetException e){
			e.printStackTrace();
		}
	}
}
