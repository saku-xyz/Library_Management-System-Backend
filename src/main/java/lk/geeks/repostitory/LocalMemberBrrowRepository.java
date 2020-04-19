package lk.geeks.repostitory;

import lk.geeks.entity.LocalBookBrrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocalMemberBrrowRepository extends JpaRepository<LocalBookBrrow,Integer> {

    @Query(value = "SELECT * FROM local_book_brrow WHERE retrun_date=:retrun_date ",nativeQuery = true)
    List<LocalBookBrrow> findByRetrunDate(@Param("retrun_date") String date);
}
