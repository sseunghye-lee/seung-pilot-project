package com.sseung.pilot.seungpilotproject.business.board.repo;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long> {
}
