package multi.second.project.domain.todo.dto.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import multi.second.project.domain.comment.domain.Comment;
import multi.second.project.domain.todo.domain.AccomodationTodo;
import multi.second.project.domain.todo.domain.BudgetType;
import multi.second.project.domain.todo.domain.Todo;
import multi.second.project.domain.todolist.domain.TodoList;

@Data
@NoArgsConstructor
public class AccomodationTodoResponse {

	private Long tdIdx;
	private String title;
	private String contents;
	private LocalDateTime regDate;
	private Boolean isPrivate;
	private String address;

	public AccomodationTodoResponse(AccomodationTodo entity) {
		this.tdIdx = entity.getTdIdx();
		this.title = entity.getTitle();
		this.contents = entity.getContents();
		this.regDate = entity.getRegDate();
		this.isPrivate = entity.getIsPrivate();
		this.address = entity.getAddress();
//		this.userId = entity.getMember().getUserId();
		
	}
	
	public String getRegDateAsDate() {
		return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public String getRegDateAsTime() {
		return regDate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
	public static List<AccomodationTodoResponse> toDtoList(List<AccomodationTodo> entityList){
		return entityList.stream().map(e -> new AccomodationTodoResponse(e)).collect(Collectors.toList());
	}

}
