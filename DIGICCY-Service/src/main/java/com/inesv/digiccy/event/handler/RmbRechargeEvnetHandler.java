package com.inesv.digiccy.event.handler;

import com.inesv.digiccy.dto.RmbRechargeDto;
import com.inesv.digiccy.event.RmbRechargeEvnet;
import com.inesv.digiccy.persistence.finance.RmbRechargePersistence;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class RmbRechargeEvnetHandler {

	@Autowired
	private RmbRechargePersistence rmbRechargePersistence;

	@EventHandler
	public void handler(RmbRechargeEvnet evnet) {
		RmbRechargeDto rmbRechargeDto = new RmbRechargeDto();
		rmbRechargeDto.setId(evnet.getId());
		rmbRechargeDto.setUser_no(evnet.getUser_no());
		rmbRechargeDto.setRecharge_type(evnet.getRecharge_type());
		rmbRechargeDto.setRecharge_price(evnet.getRecharge_price());
		rmbRechargeDto.setRecharge_order(evnet.getRecharge_order());
		rmbRechargeDto.setActual_price(evnet.getActual_price());
		rmbRechargeDto.setState(evnet.getState());
		rmbRechargeDto.setDate(evnet.getDate());
		String operating = evnet.getOperating();
		switch (operating) {
		case "insert":
			rmbRechargePersistence.addRecharge(rmbRechargeDto);
			break;
		case "updateRechargeInfo":
			rmbRechargePersistence.addRecharge(rmbRechargeDto);
			break;
		case "updateStatus":
			rmbRechargePersistence.updateState(rmbRechargeDto);
			break;
		case "confirm":
			try {
				rmbRechargePersistence.confirmToOrder(rmbRechargeDto.getRecharge_order());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

}
