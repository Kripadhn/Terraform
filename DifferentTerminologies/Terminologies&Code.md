Terraform has its own terminology, which can be confusing for new users. Here are some common Terraform terms with their explanations and code examples:


1. Provider: A provider is a Terraform component that is responsible for managing a specific type of infrastructure, such as AWS, Google Cloud, Microsoft Azure, etc.

provider "aws" {
  region = "us-west-2"
}


2. Resource: A resource is a Terraform component that represents a specific piece of infrastructure, such as a virtual machine, a database, a security group, etc.

resource "aws_instance" "example" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t2.micro"
}




3. Data Source: A data source is a Terraform component that retrieves information from the infrastructure, such as the public IP address of a virtual machine, the subnet ID of a VPC, etc.

data "aws_subnet_ids" "example" {
  vpc_id = aws_vpc.example.id
}

output "subnet_ids" {
  value = data.aws_subnet_ids.example.ids
}



4. Module: A module is a Terraform component that encapsulates a reusable piece of Terraform code. Modules can be used to organize Terraform code and simplify management.

module "frontend" {
  source = "./module/frontend"

  vpc_id = aws_vpc.example.id
}



5. Variables: Variables are Terraform components that can be used to input values into Terraform code, such as the name of a resource, the size of a virtual machine, etc.

variable "instance_type" {
  type    = string
  default = "t2.micro"
}

resource "aws_instance" "example" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = var.instance_type
}



6. Outputs: Outputs are Terraform components that can be used to output values from Terraform code, such as the public IP address of a virtual machine, the endpoint of a database, etc.

output "public_ip" {
  value = aws_instance.example.public_ip
}




7. State: The state is a Terraform component that keeps track of the infrastructure that has been created and managed by Terraform. The state is stored in a Terraform state file, which can be stored locally or remotely.

terraform {
  backend "s3" {
    bucket = "my-terraform-state"
    key    = "state.tfstate"
    region = "us-west-2"
  }
}



8. Provisioners: Provisioners are Terraform components that can be used to run scripts or perform other actions on the infrastructure after it has been created.

resource "aws_instance" "example" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t2.micro"

  provisioner "local-exec" {
    command = "echo Hello, World!"
  }
}



9. Input Variables: Input variables are Terraform variables that are used to input values into Terraform code. Input variables can be defined in Terraform code or in a separate variables file.

variable "region" {
  type    = string
  default = "us-west-2"
}

provider "aws" {
  region = var.region
}


10. Workspaces: Workspaces are Terraform components that can be used to create multiple instances of the same Terraform code with different variables and state. Workspaces are useful for managing multiple environments, such as development, staging, and production.

terraform workspace new dev
terraform workspace new prod

terraform workspace select dev
terraform apply

terraform workspace select prod
terraform apply