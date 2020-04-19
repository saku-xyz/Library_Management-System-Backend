package lk.geeks.repostitory;

import lk.geeks.entity.ForeignMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignMemberRepository extends JpaRepository<ForeignMember,String> {
}
