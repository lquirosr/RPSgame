package controllers;

import play.mvc.Controller;
import play.mvc.Result;
play.mvc.Results;

public class Instructions extends Controller {

    public static void index() {
        render();
    }
	public static upload() {
	  MultipartFormData body = request().body().asMultipartFormData();
	  FilePart picture = body.getFile("picture");
	  if (picture != null) {
	    String fileName = picture.getFilename();
	    String contentType = picture.getContentType(); 
	    File file = picture.getFile();
	    return ok("File uploaded");
	  } else {
	    flash("error", "Missing file");
	    return redirect(routes.Application.index());    
	  }
	}

}
