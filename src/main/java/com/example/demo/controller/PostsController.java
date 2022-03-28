package com.example.demo.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Post;
import com.example.demo.services.PostsService;
@RestController
public class PostsController 
{
	@Autowired
	private PostsService service;
	
	@RequestMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
    public List<Post> getPosts()
	{
    	return service.getPosts();
    }
	@RequestMapping("/employee/{id}/")
	@ResponseStatus(HttpStatus.CREATED)
	public Post getPost( @RequestBody int id) 
	{
		return service.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/employee")
	
	@ResponseStatus(HttpStatus.CREATED)
	public void addPost( @Valid @RequestBody Post listElement)
	{
		
		service.addPost(listElement);
		
	}
	
	
  
   
   
	@GetMapping( value = "/{postId}/")
    	  public List<Post> trigger(@PathVariable String postId) 
    	{
   	        List<String> ids = Arrays.asList(postId.split(","));
   	        List<Post> myList = new ArrayList<Post>();   
   	        for(String id:ids)
 	          {
  	             int getid = Integer.parseInt(id);
  	              myList.add(service.getPost(getid));
  	              
  	              
  	          }
  	              
   	       return myList;
   	}
	
	
   	
    	
	@DeleteMapping( value = "/{ID}/")
	  public List<Post> trigger1(@PathVariable String ID) 
	{
	        List<String> ids = Arrays.asList(ID.split(","));
	        List<Post> myList = new ArrayList<Post>();   
	        for(String id:ids)
       {
           int getid = Integer.parseInt(id);
         deletePost(getid);
            
            
        }
			return myList;
            
	      
	}
    	
  	          	    
@RequestMapping(method = RequestMethod.PUT,value ="/employee/id")

	@ResponseStatus(HttpStatus.CREATED)
	public void updatePost(@Valid @RequestBody @PathVariable Post post) 
	{
		 service.updatePost(post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
	
	public void deletePost(@Valid @PathVariable int id)
	{
		 service.deletePost(id);
	}
	
}




