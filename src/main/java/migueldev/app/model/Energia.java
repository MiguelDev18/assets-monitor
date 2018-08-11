package migueldev.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Energia")
public class Energia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int energiaDia;
	private Date dia;
	
	@ManyToOne
	@JoinColumn(name = "idHogares")
	private Hogar hogar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnergiaDia() {
		return energiaDia;
	}
	public void setEnergiaDia(int energiaDia) {
		this.energiaDia = energiaDia;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Hogar getHogar() {
		return hogar;
	}
	public void setHogar(Hogar hogar) {
		this.hogar = hogar;
	}
	@Override
	public String toString() {
		return "Energia [id=" + id + ", energiaDia=" + energiaDia + ", dia=" + dia + ", hogar=" + hogar + "]";
	}
	
	
}
