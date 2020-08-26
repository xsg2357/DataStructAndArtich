package com.test.data.sign_pattern.chain_responsibility;

public class ViceSchoolMasterApprover extends Approver {

    public ViceSchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 10000 && purchaseRequest.getPrice() <= 30000){
            System.out.println("请求编号:"+purchaseRequest.getId()+"被"+this.name+"处理了");
        }else{
//            System.out.println(this.name+"不能处理");
            approver.processRequest(purchaseRequest);
        }
    }
}
