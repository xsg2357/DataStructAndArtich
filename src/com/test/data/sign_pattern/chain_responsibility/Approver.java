package com.test.data.sign_pattern.chain_responsibility;

public abstract  class Approver {

    Approver approver;//下一个处理者

    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void  processRequest(PurchaseRequest purchaseRequest);

}
