package com.demo.ektha.serviceinfo.repositotory;

import com.demo.ektha.serviceinfo.Model.Notes;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepositotory extends JpaRepository<Notes,Long>{

}
