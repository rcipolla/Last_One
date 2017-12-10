package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

import org.apache.poi.ss.formula.functions.*;
public class TestFinance {

	
	@Test 
	public void TestAmounts()
	{
		double dMonthsToWork = 40 * 12;
		double rAnnualReturnWorking = 0.07 / 12;
		double dMonthsRetired = 20 * 12;
		double rAnnaulReturnRetired = 0.02 / 12;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		double pv = FinanceLib.pv(rAnnaulReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
		
		double pmt = FinanceLib.pmt(rAnnualReturnWorking, dMonthsToWork, 0, pv, false);
		
		System.out.println(pv);
		System.out.println(pmt);
	}
	
	
	@Test
	public void TestPV()
	{
		double r = 0.025 / 12;
		double n = 20 * 12;
		double y = 10000-2642;
		double f = 0;
		boolean t = false;
		double pv = FinanceLib.pv(r, n, y, f, t);
		
		//System.out.println(pv);
		
	}
	
	@Test
	public void TestPMT() {
		double r = 0.042 / 12;
		double n = 60;
		double p = 30000;
		double f = 0;
		boolean t = false;
		
		double d = FinanceLib.pmt(r, n, p, f, t);
		
		//System.out.println(d);
		
		
		
	}
	
	@Test
	public void TestRetirement() {
		int dyearsToWork = 40;
		double rAnnualReturnWorking = 0.07;
		int dyearsRetired = 20;
		double rAnnaulReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		
		Retirement r = new Retirement(dyearsToWork,rAnnualReturnWorking,dyearsRetired,rAnnaulReturnRetired,dRequiredIncome,dMonthlySSI);
		assertEquals(r.AmountToSave(),554.13,.1);
		assertEquals(r.TotalAmountSaved(),1454485.55,.1);
		
		
		
	}

}
