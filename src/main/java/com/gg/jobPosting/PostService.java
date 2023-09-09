package com.gg.jobPosting;

import java.util.List;

public interface PostService {
    public abstract List<PostDTO> postList();

    public abstract List<PostDTO> compostList(String co_ID);
}
