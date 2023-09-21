package com.besmartkinopoiskservice.controller;

import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.service.CommentService;
import com.besmartkinopoiskservice.to.request.comment.CreateCommentRequestTO;
import com.besmartkinopoiskservice.to.request.comment.UpdateCommentRequestTO;
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

    @GetMapping("/list")
    public ResponseEntity<GetCommentsResponseTO> getMovieComments(@RequestParam(name = "movieid") UUID movieId, @RequestParam(name = "userid") UUID userId ) throws ServiceException {
        return ResponseEntity.ok(commentService.getComments(movieId, userId));
    }

    //owner, moderator, admin
    @PutMapping("")
    public ResponseEntity<EmptyResponseTO> updateUserComments(@RequestBody UpdateCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner
    @PostMapping("")
    public ResponseEntity<EmptyResponseTO> addUserComments(@RequestBody CreateCommentRequestTO request) {
        return ResponseEntity.ok(null);
    }

    //owner, moderator, admin
    @DeleteMapping("")
    public ResponseEntity<EmptyResponseTO> deleteUserComments(@RequestParam(name = "commentid") UUID commentId) {
        return ResponseEntity.ok(null);
    }
}
