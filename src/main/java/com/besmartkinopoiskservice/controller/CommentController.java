package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.CommentService;
import com.besmartkinopoiskservice.to.request.userrequest.DeleteCommentRequestTO;
import com.besmartkinopoiskservice.to.request.userrequest.UpdateCommentRequestTO;
import com.besmartkinopoiskservice.to.response.EmptyResponseTO;
import com.besmartkinopoiskservice.to.response.GetCommentsResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<GetCommentsResponseTO> getMovieComments(@RequestParam(name = "movieid") UUID movieId, @RequestParam(name = "userid") UUID userId ) throws ServiceException {
        return ResponseEntity.ok(commentService.getComments(movieId, userId));
    }

    //owner, moderator, admin
    @PutMapping("/comments/update")
    public ResponseEntity<EmptyResponseTO> updateUserComments(@RequestBody UpdateCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner
    @PutMapping("/comments/add")
    public ResponseEntity<EmptyResponseTO> addUserComments(@RequestBody UpdateCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner, moderator, admin
    @PutMapping("/comments/delete")
    public ResponseEntity<EmptyResponseTO> deleteUserComments(@RequestBody DeleteCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }
}
