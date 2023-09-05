package com.besmartkinopoiskservice.to.response;

import com.besmartkinopoiskservice.to.domain.CommentDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetUserCommentsResponseTO {
    private List<CommentDetailsTO> comments;
}
