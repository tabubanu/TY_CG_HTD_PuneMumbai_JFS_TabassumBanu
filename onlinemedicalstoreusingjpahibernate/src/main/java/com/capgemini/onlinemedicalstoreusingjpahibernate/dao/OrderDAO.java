package com.capgemini.onlinemedicalstoreusingjpahibernate.dao;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.OrderHistory;

public interface OrderDAO {

	public boolean getHistory(OrderHistory orderHistory);

}
