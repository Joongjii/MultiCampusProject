package multi.second.project.domain.todo;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import multi.second.project.domain.comment.dto.request.CommentModifyRequest;
import multi.second.project.domain.comment.dto.request.CommentRegistRequest;
import multi.second.project.domain.gallery.dto.request.GalleryModifyRequest;
import multi.second.project.domain.gallery.dto.request.GalleryRegistRequest;
import multi.second.project.domain.gallery.dto.response.GalleryDetailResponse;
import multi.second.project.domain.member.UserPrincipal;
import multi.second.project.domain.member.dto.Principal;
import multi.second.project.domain.todo.dto.request.TodoModifyRequest;
import multi.second.project.domain.todo.dto.request.TodoRegistRequest;
import multi.second.project.domain.todolist.dto.request.TodoListModifyRequest;
import multi.second.project.domain.todolist.dto.request.TodoListRegistRequest;
import multi.second.project.infra.util.file.dto.FilePathDto;

@Controller
@AllArgsConstructor
@RequestMapping("todo")
public class TodoController {
	
	private final TodoService todoService;
	private final SimpMessagingTemplate simpMessagingTemplate;

	//생성은 따로따로 만드나
	//그럼 수정은? 삭제는?
	
	@MessageMapping("upload-accomodation/{tpIdx}")
	public void uploadAccomodation(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoRegistRequest dto,
			Long tlIdx
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-accomodation/" + tpIdx, todoService.createAccomodationTodo(dto, tpIdx, tlIdx));
		
	}
	
	@MessageMapping("upload-attractions/{tpIdx}")
	public void uploadAttractions(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoRegistRequest dto,
			Long tlIdx
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-attractions/" + tpIdx, todoService.createAttractionsTodo(dto, tpIdx, tlIdx));
		
	}
	
	@MessageMapping("upload-budget/{tpIdx}")
	public void uploadBudget(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoRegistRequest dto,
			Long tlIdx
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-budget/" + tpIdx, todoService.createBudgetTodo(dto, tpIdx, tlIdx));
		
	}
	
	@MessageMapping("upload-general/{tpIdx}")
	public void uploadGeneral(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoRegistRequest dto,
			Long tlIdx
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-general/" + tpIdx, todoService.createGeneralTodo(dto, tpIdx, tlIdx));
		
	}
	
	@MessageMapping("upload-transport/{tpIdx}")
	public void uploadTransport(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoRegistRequest dto,
			Long tlIdx
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-transport/" + tpIdx, todoService.createTransportTodo(dto, tpIdx, tlIdx));
		
	}
	
	//////////////////////////
	
	
	
	@MessageMapping("modify-accomodation/{tpIdx}")
	public void modifyAccomodation(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoModifyRequest dto
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-accomodation/" + tpIdx, todoService.modifyAccomodationTodo(dto));
		
	}
	@MessageMapping("modify-attractions/{tpIdx}")
	public void modifyAttractions(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoModifyRequest dto
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-attractions/" + tpIdx, todoService.modifyAttractionsTodo(dto));
		
	}
	@MessageMapping("modify-budget/{tpIdx}")
	public void modifyBudget(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoModifyRequest dto
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-budget/" + tpIdx, todoService.modifyBudgetTodo(dto));
		
	}
	@MessageMapping("modify-general/{tpIdx}")
	public void modifyGeneral(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoModifyRequest dto
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-general/" + tpIdx, todoService.modifyGeneralTodo(dto));
		
	}
	@MessageMapping("modify-transport/{tpIdx}")
	public void modifyTransport(
			@DestinationVariable("tpIdx") Long tpIdx,
			TodoModifyRequest dto
			) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/upload-transport/" + tpIdx, todoService.modifyTransportTodo(dto));
		
	}
	
	///////////////////////
	
	@MessageMapping("remove-transport/{tpIdx}")
	public void remove(
			@DestinationVariable("tpIdx") Long tpIdx,
			Long tlIdx,
			Long tdIdx
			) {
		simpMessagingTemplate.convertAndSend("/topic/remove-transport/" + tpIdx, todoService.deleteTodo(tdIdx, tlIdx));
		
		
	}
	
	
	
	
}
