package org.tiankafei.common.ioc;

import org.junit.Before;
import org.junit.Test;

public class PersonalIncomeTaxTest {

    @Before
    public void steup() {

    }

    @Test
    public void personalIncomeTaxTest() {
        testNewPersonalIncomeTax(5000, 20000);
        testOldPersonalIncomeTax(20000);
//        testNewPersonalIncomeTax(6000, 20000);
//        testNewPersonalIncomeTax(7000, 20000);
//        testNewPersonalIncomeTax(8000, 20000);
//
//
//        testNewPersonalIncomeTax(5000, 21000);
//        testNewPersonalIncomeTax(5000, 22000);
//        testNewPersonalIncomeTax(5000, 23000);
//        testNewPersonalIncomeTax(5000, 24000);
//
//
//        testNewPersonalIncomeTax(5000, 28000);
//        testNewPersonalIncomeTax(6000, 28000);
//        testNewPersonalIncomeTax(7000, 28000);
    }

    private void testNewPersonalIncomeTax(int markingPoint, int incomeBeforeTax) {
        incomeBeforeTax += 500;
        //税前工资
        System.out.println("税前工资 = " + incomeBeforeTax);
        //社保缴费基数
        int socialSecurityContributionBase = 21394;
        System.out.println("社保缴费基数 = " + socialSecurityContributionBase);
        //社保扣税
        double socialSecurityTaxDeduction = socialSecurityContributionBase * 0.22;
        System.out.println("社保扣税 = " + socialSecurityTaxDeduction);
        System.out.println("个税起征点 = " + markingPoint);
        System.out.println("扣除五险一金后月收入 = " + (incomeBeforeTax - socialSecurityTaxDeduction));
        //需要缴税的钱
        double needPayTaxes = incomeBeforeTax - socialSecurityTaxDeduction - markingPoint;
        System.out.println("需要缴税的钱 = " + needPayTaxes);

        double taxAmount = 0;
        if (needPayTaxes <= 3000) {
            taxAmount += taxAmount * 0.03;
        } else if (needPayTaxes > 3000 && needPayTaxes <= 12000) {
            taxAmount += 3000 * 0.03;
            taxAmount += (needPayTaxes - 3000) * 0.1;
        } else if (needPayTaxes > 12000 && needPayTaxes <= 25000) {
            taxAmount += 3000 * 0.03;
            taxAmount += (12000 - 3000) * 0.1;
            taxAmount += (needPayTaxes - 12000) * 0.2;
        } else if (needPayTaxes > 25000 && needPayTaxes <= 35000) {
            taxAmount += 3000 * 0.03;
            taxAmount += (12000 - 3000) * 0.1;
            taxAmount += (25000 - 12000) * 0.2;
            taxAmount += (needPayTaxes - 25000) * 0.25;
        } else if (needPayTaxes > 35000 && needPayTaxes <= 55000) {
            taxAmount += 3000 * 0.03;
            taxAmount += (12000 - 3000) * 0.1;
            taxAmount += (25000 - 12000) * 0.2;
            taxAmount += (35000 - 25000) * 0.25;
            taxAmount += (needPayTaxes - 35000) * 0.3;
        } else if (needPayTaxes > 55000 && needPayTaxes <= 80000) {
            taxAmount += 3000 * 0.03;
            taxAmount += (12000 - 3000) * 0.1;
            taxAmount += (25000 - 12000) * 0.2;
            taxAmount += (35000 - 25000) * 0.25;
            taxAmount += (55000 - 35000) * 0.3;
            taxAmount += (needPayTaxes - 55000) * 0.35;
        } else {
            taxAmount += 3000 * 0.03;
            taxAmount += (12000 - 3000) * 0.1;
            taxAmount += (25000 - 12000) * 0.2;
            taxAmount += (35000 - 25000) * 0.25;
            taxAmount += (55000 - 35000) * 0.3;
            taxAmount += (80000 - 55000) * 0.35;
            taxAmount += (needPayTaxes - 80000) * 0.45;
        }
        System.out.println("个人应缴的税 = " + taxAmount);

        System.out.println("实际到手工资 = " + (incomeBeforeTax - socialSecurityTaxDeduction - taxAmount));

        System.out.println("==============================================================");
    }

    private void testOldPersonalIncomeTax(int incomeBeforeTax) {
        incomeBeforeTax += 590;
        int markingPoint = 3500;
        //税前工资
        System.out.println("税前工资 = " + incomeBeforeTax);
        //社保缴费基数
        int socialSecurityContributionBase = 21394;
        System.out.println("社保缴费基数 = " + socialSecurityContributionBase);
        //社保扣税
        double socialSecurityTaxDeduction = socialSecurityContributionBase * 0.22;
        System.out.println("社保扣税 = " + socialSecurityTaxDeduction);
        System.out.println("个税起征点 = " + markingPoint);
        System.out.println("扣除五险一金后月收入 = " + (incomeBeforeTax - socialSecurityTaxDeduction));
        //需要缴税的钱
        double needPayTaxes = incomeBeforeTax - socialSecurityTaxDeduction - markingPoint;
        System.out.println("需要缴税的钱 = " + needPayTaxes);

        double taxAmount = 0;
        if (needPayTaxes <= 1500) {
            taxAmount += taxAmount * 0.03;
        } else if (needPayTaxes > 1500 && needPayTaxes <= 4500) {
            taxAmount += 1500 * 0.03;
            taxAmount += (needPayTaxes - 1500) * 0.1;
        } else if (needPayTaxes > 4500 && needPayTaxes <= 9000) {
            taxAmount += 1500 * 0.03;
            taxAmount += (4500 - 1500) * 0.1;
            taxAmount += (needPayTaxes - 4500) * 0.2;
        } else if (needPayTaxes > 9000 && needPayTaxes <= 35000) {
            taxAmount += 1500 * 0.03;
            taxAmount += (4500 - 1500) * 0.1;
            taxAmount += (9000 - 4500) * 0.2;
            taxAmount += (needPayTaxes - 9000) * 0.25;
        } else if (needPayTaxes > 35000 && needPayTaxes <= 55000) {
            taxAmount += 1500 * 0.03;
            taxAmount += (4500 - 1500) * 0.1;
            taxAmount += (9000 - 4500) * 0.2;
            taxAmount += (35000 - 9000) * 0.25;
            taxAmount += (needPayTaxes - 35000) * 0.3;
        } else if (needPayTaxes > 55000 && needPayTaxes <= 80000) {
            taxAmount += 1500 * 0.03;
            taxAmount += (4500 - 1500) * 0.1;
            taxAmount += (9000 - 4500) * 0.2;
            taxAmount += (35000 - 9000) * 0.25;
            taxAmount += (55000 - 35000) * 0.3;
            taxAmount += (needPayTaxes - 55000) * 0.35;
        } else {
            taxAmount += 1500 * 0.03;
            taxAmount += (4500 - 1500) * 0.1;
            taxAmount += (9000 - 4500) * 0.2;
            taxAmount += (35000 - 9000) * 0.25;
            taxAmount += (55000 - 35000) * 0.3;
            taxAmount += (80000 - 55000) * 0.35;
            taxAmount += (needPayTaxes - 80000) * 0.45;
        }
        System.out.println("个人应缴的税 = " + taxAmount);

        System.out.println("实际到手工资 = " + (incomeBeforeTax - socialSecurityTaxDeduction - taxAmount));

        System.out.println("==============================================================");
    }

}
