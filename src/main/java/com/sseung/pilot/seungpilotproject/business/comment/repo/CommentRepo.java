package com.sseung.pilot.seungpilotproject.business.comment.repo;

import com.sseung.pilot.seungpilotproject.business.comment.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {
}
