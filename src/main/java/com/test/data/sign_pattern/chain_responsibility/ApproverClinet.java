package com.test.data.sign_pattern.chain_responsibility;

public class ApproverClinet {

    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 1000, 1);

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        ColleagueApprover colleagueApprover = new ColleagueApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("韩校长");

        // 形成环链
        departmentApprover.setApprover(colleagueApprover);
        colleagueApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        schoolMasterApprover.processRequest(purchaseRequest);
    }
}
