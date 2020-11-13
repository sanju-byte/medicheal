package com.helxir.medicheal.service;

import com.helxir.medicheal.bean.PaymentCallback;
import com.helxir.medicheal.bean.PaymentDetail;

public interface PaymentService {
	PaymentDetail proceedPayment(PaymentDetail paymentDetail);
	String payuCallback(PaymentCallback paymentResponse);
}
