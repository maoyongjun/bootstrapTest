Create table sfcskunolabel(
Id	       int identity(1,1),
parentSkuno VARCHAR(100), 
skuno		VARCHAR(100),
label		NVARCHAR(100),
qty			int,
isPreDo		NVARCHAR(100),
others		NVARCHAR(200),
valid		VARCHAR(2) DEFAULT '1'
)