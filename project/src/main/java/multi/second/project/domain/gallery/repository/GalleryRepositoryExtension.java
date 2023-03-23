package multi.second.project.domain.gallery.repository;

import java.util.List;

import multi.second.project.domain.gallery.domain.Gallery;


public interface GalleryRepositoryExtension {
	
	List<Gallery> testQueryDSL(String title, boolean isDel);

// 이와 같이 Repository에서 인터페이스를 분리하는 이유는 여러 가지가 있을 수 있지만,
// 가장 일반적인 이유는 SRP(Single Responsibility Principle) 원칙을 지키기 위함입니다.
// 인터페이스를 분리함으로써 해당 Repository가 어떤 역할을 하는지 명확하게 분리할 수 있으며,
// 관심사의 분리를 통해 코드의 가독성과 유지보수성을 높일 수 있습니다.

}