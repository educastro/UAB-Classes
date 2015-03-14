package lab01;
import java.text.DecimalFormat;

public class Complex {
	private double real;
	private double imag;
	
	private final static double tolerance = 0.0001;
	
	public Complex() {
		real = imag = 0.0;
	}

	public Complex(double real, double imag) {
 		this.real = real;
		this.imag = imag;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}

	public Complex add(Complex c) {
		return new Complex(real + c.real, imag + c.imag);
	}

	public Complex subtract(Complex c) {
		return new Complex(real - c.real, imag - c.imag);
	}

	public Complex multiply(Complex c) {
		double rpart = real * c.real - imag * c.imag;
		double ipart = real * c.imag + imag * c.real;
		return new Complex(rpart, ipart);
	}

	public Complex divide(Complex c) {
		double rpart = ((real * c.real) + (imag * c.imag)) / normSqr();
		double ipart = ((imag * c.real) - (real * c.imag)) / normSqr();

		return new Complex(rpart, ipart);
	}

	private double normSqr() {
		return (real * real + imag * imag);
	}

	public double abs() {
		return Library.square_root(real * real + imag * imag);
		
	}

	public boolean equals(Complex c) {
		if(subtract(c).real < tolerance)
			return true;
		else
			return false;
	}

	public String toString() {
		DecimalFormat fmt = new DecimalFormat("0.000");

		return new String(fmt.format(real) + ((imag < 0) ? " - " : " + ")
				+ fmt.format(Math.abs(imag)) + "i");
	}
}