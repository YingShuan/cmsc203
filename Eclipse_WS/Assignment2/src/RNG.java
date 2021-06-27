import java.util.Random;

public class RNG {
	private int valGoal;
	private int ansCount = 1;

	 
	public int rang(int upperBound)
	{
		Random ran = new Random();
		valGoal = ran.nextInt(upperBound);
		return valGoal; 
	}
	
	public void resetCount(int newCount)
	{
		ansCount = newCount;
	}
	
	public int getCount ()
	{
		return ansCount;
	}

	public boolean inputValidation(int valGuess, int boundUpper, int boundLower)
	{
		return (valGuess <= boundUpper) && (valGuess >= boundLower);
	}
}
