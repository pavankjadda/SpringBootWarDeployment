import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Category} from "../category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient:HttpClient)
  { }

  public loadCategories(url:string)
  {
    return this.httpClient.get<Category[]>(url);
  }
}
