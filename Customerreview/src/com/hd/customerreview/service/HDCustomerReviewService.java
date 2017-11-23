package com.hd.customerreview.service;



import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.ProductModel;

/**
 * This represents the operation related to customer review .
 * 
 * @author jagnya.datta
 *
 */
public interface HDCustomerReviewService  extends CustomerReviewService{

	Integer getNumberOfReviewsByRatingRange(ProductModel arg0,double min,double max);
    
	CustomerReviewModel createCustomerReview(Double rating, String headline, String comment, UserModel user,
			ProductModel product) ;

}
