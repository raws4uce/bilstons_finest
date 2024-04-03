package weka_test;

import Student.Level;

enum Difficulty {
	EASY, MEDIUM, HARD;
}
public class performanceChecker {
	public static void main(String[] args) {
		try {
			double performance = getPerformance(false, Difficulty.HARD,100, 10040, 39);
			System.out.println("this is num " +performance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static double getPerformance(boolean correct, Difficulty hard, int time, int input, int answer) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static final double[][] pRangeToValue = {
			{5, 6.6},
			{15, 6.0},
			{20, 5.0},
			{30, 4.0}
	};
	private static final double[][] nRangeToValue = {
			{-5, 6.6},
			{-15, 6.0},
			{-20, 5.0},
			{-30, 4.0}
	};
	private static final double[][] multiplier = {
			{5, 1.5},
			{15, 1.4},
			{20, 1.3},
			{30, 1.2}
	};

	public static Double getPerformance(boolean correct, Level dif, long time, int input , int answer) {
		Double num = 0.0;
		Double multipliers = 0.0;

		int difference = input - answer;
		System.out.println(difference);
		if(correct) {
			num = 10.0;
		}else {
			if(difference<0) {
				//-ranges
				for (double[] range : nRangeToValue) {
					if (difference <= range[0]) {
						num = range[1];
						break;
					}else {
						num = 1.0;
					}
				}
			}else {
				//+ranges
				for (double[] range : pRangeToValue) {
					if (difference <= range[0]) {
						num = range[1];
						break;
					}else {
						num = 1.0;
					}
				}
			}
			//time multiplier
			for (double[] m : multiplier) {
				if (time <= m[0]) {
					multipliers = m[1];
					break;
				}else {
					multipliers = 1.1;
				}
			}
			double dMul = 0.0; 
			switch(dif) {
			case EASY:
				dMul= 0.33;
				break;
			case MEDIUM:
				dMul = 0.66;
				break;
			case HARD:
				dMul = 1.0;
				break;
			}
			System.out.println(multipliers+ " , " + num +" , " + dMul);
			num *= multipliers * dMul;
			if (num>10) {
				num=10.0;
			}
		}


		return num;
	}

}