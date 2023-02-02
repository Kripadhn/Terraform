module "network" {
  source = "./network"

  vpc_cidr = "10.0.0.0/16"
  subnet_cidr = "10.0.1.0/24"
}

module "web_server" {
  source = "./web_server"

  subnet_id = module.network.subnet_id
  instance_count = 2
}
