package Zakat;

public class ProcedureCalcule 
{
	public double ZakatNuméraire(double a)
	{
		final double quorum = 705.5;
		double quote_part = 0;
		if(a >= quorum)
			quote_part = (a * 2.5) / 100;
		return quote_part;
	}
	
	public double ZakatOr(double a, int carat)
	{
		double quote_part = 0;
		switch(carat)
		{
			case 24: { if(a >= 85)
						quote_part = (a * 2.5) / 100;};break;
			case 21: { if (a >= 97)
						quote_part = (a * 2.5) / 100;};break;
			case 18:{ if (a >= 113)
						quote_part = (a * 2.5) / 100;};break;
		}
		return quote_part;
	}
	
	public double ZakatArgent(double a)
	{
		final double quorum = 595;
		double quote_part = 0;
		if(a >= quorum)
			quote_part = (a * 2.5) / 100;
		return quote_part;
		 
	}

	public double ZakatAgricole(double a, boolean IA)
	{
		double quote_part = 0;
		if (IA)
			quote_part = (a * 10) / 100;
		else
			quote_part = (a * 5) / 100;
		return quote_part;
	}

	public double ZakatBlé(double a, boolean IA)
	{
		final double quorum = 675;
		double quote_part = 0;
		if(a >= quorum)
		{
			if (IA)
				quote_part = (a * 10) / 100;
			else
				quote_part = (a * 5) / 100;
		}
		return quote_part;
	}

	public String ZakatOvin(int a)
	{
		String quote_part;
		if(a >= 40 & a <= 120) 
			quote_part = "1C";
		else
		{
			if (a >= 121 & a <= 200)
				quote_part = "2C";
			else
			{
				if (a >= 201 & a <= 399)
					quote_part = "3C";
				else
				{
					if (a > 399)
					{
						int quotient = a / 100;
						quote_part = Integer.toString(quotient) +"C";
					}
					else
						quote_part = "0";
				}
			}
				
			
		}
	return quote_part;
	}

	public String ZakatBovin(int a)
	{
		String quote_part;
		if(a >= 30 & a <= 39) 
			quote_part = "T";
		else
		{
			if (a >= 40 & a <= 59)
				quote_part = "Mo";
			else
			{
				if (a >= 60 & a <= 69)
					quote_part = "2T";
				else
				{
					if(a >= 70 & a <= 79) 
						quote_part = "Mo + T";
					else
					{
						if (a >= 80 & a <= 89)
							quote_part = "2Mo";
						else
						{
							if (a >= 90 & a <= 99)
								quote_part = "3T";
							else
							{
								if (a >= 100 & a <= 119)
									quote_part = "Mo + 2T";
								else
									{
										if (a >= 120 & a <= 129)
											quote_part = "3Mo ou 4T";
										else
										{
											if(a >= 120)
											{
												int quotient= a / 40;
												int reste = (a % 40) / 30;
												quote_part = Integer.toString(quotient) +"Mo" + " + " + Integer.toString(reste) +"T";
											}
											else
											{
												quote_part = "0";
											}
										}
												
									}
								}
										
						  	}
						}
				}
			}
		}
		
		return quote_part;
	}

	public String ZakatChameaux(int a)
	{
		String quote_part;
		if(a >= 5 & a <= 24)
			quote_part = Integer.toString(a / 5) + "C";
		else
		{
			if(a >= 25 & a <= 35)
				quote_part = "M";
			else
			{
				if(a >= 36 & a <= 45)
					quote_part = "L";
				else
				{
					if(a >= 46 & a <= 60)
						quote_part = "H";
					else
					{
						if(a >= 61 & a <= 75)
							quote_part = "J";
						else
						{
							if(a >= 76 & a <= 90)
								quote_part = "2L";
							else
							{
								if(a >= 91 & a <= 120)
									quote_part = "2H";
								else
								{
									if(a > 120)
									{
										int quotient = a / 50;
										int reste = a % 50;
										int res = reste / 40;
										if(quotient == 0)
											quote_part = Integer.toString(res)+"L";
										else
										{
											if(res == 0)
												quote_part = Integer.toString(quotient)+"H";
											else
												quote_part = Integer.toString(quotient) +"H" +" + "+Integer.toString(res)+"L";
										}
									}
									else
										quote_part = "0";
								}
							}
						}
					}
				}
					
			}
		}
			
		
		
		return quote_part;
	}
}
