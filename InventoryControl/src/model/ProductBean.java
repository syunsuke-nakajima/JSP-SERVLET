package model;

import java.io.Serializable;

/**
 * 情報を格納しておくクラス
 * @author nakajimashunsuke
 *
 */

public class ProductBean implements Serializable {

	private static final long serialVersionUID  = 1L;


	private int id;
	private int genreCode;
	private String name;
	private String maker;
	private int price;
	private int stock;
	private int number;
	private String remarks;

	public ProductBean() { }

	public ProductBean(int id, int genreCode, String name, String maker, int price, int stock, int number,
			String remarks) {
		super();
		this.id = id;
		this.genreCode = genreCode;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.stock = stock;
		this.number = number;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}