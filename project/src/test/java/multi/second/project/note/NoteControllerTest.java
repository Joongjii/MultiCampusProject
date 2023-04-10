package multi.second.project.note;

import multi.second.project.domain.member.MemberRepository;
import multi.second.project.domain.member.domain.Member;
import multi.second.project.domain.note.domain.Note;
import multi.second.project.domain.note.domain.Partner;
import multi.second.project.domain.note.repository.NoteRepository;
import multi.second.project.domain.note.repository.PartnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private MemberRepository memberRepository;


//    @Test
//    public void testPartnerUpload(){
////
////        Member me = memberRepository.findById("guswnd1212").get();
////        Member you = memberRepository.findById("guswnd1380").get();
//        //System.out.println("me : "+me);
//        Note note = Note.builder().build();
//        noteRepository.save(note);
//
////        Partner partner1 = Partner.builder().member(me).build();
//
////        partnerRepository.save(partner1);
////
////        note.addPartner(partner1);
//
////        Partner partner2 = Partner.builder().member(you).build();
////        partnerRepository.save(partner2);
//     //   note.addPartner(partner2);
////        noteRepository.save(note);
//
//    }

    @Test
    public void testPartnerAdd(){

        Note note = noteRepository.findById(9L).get();

        Member member = memberRepository.findById("guswnd1380").get();
        //System.out.println("me : "+me);
        Partner partner = Partner.builder().member(member).build();
        partnerRepository.save(partner);
        note.addPartner(partner);

        noteRepository.save(note);


    }
}
