package searchPutProject;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepositorySearchBuilder;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedSearchIterable;

import org.junit.runners.Parameterized;

public class GithubSearch {

    public static void main(String[] args) {
	GitHub github;
	try {
	    github = GitHub.connect();
	    PagedSearchIterable<GHRepository> repos = github.searchRepositories().q("Theories.class").language("Java").in("file").sort(
																       GHRepositorySearchBuilder.Sort.STARS).size("<" + 10000).list();
	    Iterator<GHRepository> itor = repos.iterator();
	    while(itor.hasNext()){
		GHRepository r = itor.next();
		System.out.println(r.getName());
		System.out.println(r.getFullName());
		System.out.println();
	    }
	    System.out.println(repos.getTotalCount());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	

    }

}