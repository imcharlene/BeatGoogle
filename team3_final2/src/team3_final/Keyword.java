package team3_final;

public class Keyword {
	public String name;
	public float weight;

	public Keyword(String name, float weight){
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString(){
		return "[" + name + "," + weight + "]";
	}
}
