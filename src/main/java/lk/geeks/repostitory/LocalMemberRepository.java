package lk.geeks.repostitory;

import lk.geeks.entity.LocalMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalMemberRepository extends JpaRepository<LocalMember,String> {
}
