import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
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
     this.categoryService.loadCategories('http://localhost:8080/category/list').subscribe(
       data=> {
         this.categories=data;
       }
     );

  }
}
