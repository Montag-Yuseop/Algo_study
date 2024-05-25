namespace Solution {
  class Program {
    static void Main(string[] args) {

      double.TryParse(Console.ReadLine(), out double w);
      double.TryParse(Console.ReadLine(), out double h);

      double bmi = w / Math.Pow(h, 2);

      string ans = "";
      if (bmi < 18.5) ans = "Underweight";
      else if (bmi >= 18.5 && bmi < 25) ans = "Normal weight";
      else if (bmi >= 25) ans = "Overweight";

      Console.WriteLine(ans);

    }
  }
}