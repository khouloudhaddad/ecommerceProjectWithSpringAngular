import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent {
  productForm!: FormGroup;
  listCategories: any = [];
  selectedFile!: File;
  imagePreview!: string | ArrayBuffer | null;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar,
    private adminService: AdminService
  ) {
  }

  onSelectedFile(event: any)
  {
    this.selectedFile = event.target.files[0];
    this.previewImage();
  }

  previewImage(){
    const reader = new FileReader();
    reader.onload = ()=>{
      this.imagePreview = reader.result;
    }

    reader.readAsDataURL(this.selectedFile);
  }

  ngOnInit(): void {
    this.productForm = this.fb.group({
      categoryId: [null, [Validators.required]],
      name: [null, [Validators.required]],
      price: [null, [Validators.required]],
      description: [null, [Validators.required]]
    });

    this.getAllCategories();
  }

  getAllCategories(){
    this.adminService.getAllCategories().subscribe((categories) => {
      this.listCategories = categories;
    })
  }

  addProduct(): void{
    if(this.productForm.valid){
      this.adminService.addCategory(this.productForm.value).subscribe((res) =>{
        if(res.id != null){
          this.snackBar.open("Category successfully created!", 'Close', {
            duration: 5000
          });
          this.router.navigateByUrl('/admin/dashboard');
        }else{
          this.snackBar.open(res.message, 'Close', {
            duration: 5000,
            panelClass: 'error-snackbar'
          });
        }
      })
    }else{
      this.productForm.markAllAsTouched();
    }
  }
}
