import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {CATEGORY_URL} from "src/app/app.constants";
import {environment} from "src/environments/environment";
import {Category} from "./category";
import {CategoryService} from "./category.service";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit
{
  categories: Array<Category>;

  constructor(private router:Router,
              private categoryService:CategoryService)
  { }

  ngOnInit()
  {
    this.loadCategories();
  }

  private loadCategories()
  {
     this.categoryService.loadCategories(environment.SERVER_URL+CATEGORY_URL).subscribe(
       data=> {
         this.categories=data;
       }
     );
  }
}
