package model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableChartDTO {
	private int userNum;
	private String nickName;
	private int vHuman;
	private int vAi;
	private int age;
	private String sex;
	private String location;
}