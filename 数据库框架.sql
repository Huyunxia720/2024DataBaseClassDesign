USE [master]
GO
/****** Object:  Database [newClassDesign]    Script Date: 2024/12/13 19:41:38 ******/
CREATE DATABASE [newClassDesign]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'newClassDesign', FILENAME = N'D:\360Downloads\sql\MSSQL16.SQLEXPRESS01\MSSQL\DATA\newClassDesign.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'newClassDesign_log', FILENAME = N'D:\360Downloads\sql\MSSQL16.SQLEXPRESS01\MSSQL\DATA\newClassDesign_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [newClassDesign] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [newClassDesign].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [newClassDesign] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [newClassDesign] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [newClassDesign] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [newClassDesign] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [newClassDesign] SET ARITHABORT OFF 
GO
ALTER DATABASE [newClassDesign] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [newClassDesign] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [newClassDesign] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [newClassDesign] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [newClassDesign] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [newClassDesign] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [newClassDesign] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [newClassDesign] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [newClassDesign] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [newClassDesign] SET  DISABLE_BROKER 
GO
ALTER DATABASE [newClassDesign] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [newClassDesign] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [newClassDesign] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [newClassDesign] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [newClassDesign] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [newClassDesign] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [newClassDesign] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [newClassDesign] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [newClassDesign] SET  MULTI_USER 
GO
ALTER DATABASE [newClassDesign] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [newClassDesign] SET DB_CHAINING OFF 
GO
ALTER DATABASE [newClassDesign] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [newClassDesign] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [newClassDesign] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [newClassDesign] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [newClassDesign] SET QUERY_STORE = ON
GO
ALTER DATABASE [newClassDesign] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [newClassDesign]
GO
/****** Object:  User [zwt]    Script Date: 2024/12/13 19:41:39 ******/
CREATE USER [zwt] FOR LOGIN [zwt] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Catalog]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[TNo] [varchar](8) NOT NULL,
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
	[TIdentity] [nvarchar](20) NOT NULL,
	[CYear] [int] NOT NULL,
	[IsQualification] [nvarchar](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TNo] ASC,
	[DisciplineNum] ASC,
	[SecondaryNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FirDiscipline]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FirDiscipline](
	[DisciplineNum] [varchar](255) NOT NULL,
	[DisType] [varchar](255) NULL,
	[FirOverview] [nvarchar](255) NULL,
	[FirDisName] [nvarchar](255) NULL,
	[SupplyIndicator] [int] NULL,
	[AllIndicator] [int] NULL,
	[Note] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[DisciplineNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IsSelected]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IsSelected](
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
	[State] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[DisciplineNum] ASC,
	[SecondaryNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Login]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[LoginID] [varchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[LoginID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Publicity]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publicity](
	[TNo] [varchar](8) NOT NULL,
	[ExamNo] [varchar](20) NOT NULL,
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TNo] ASC,
	[ExamNo] ASC,
	[DisciplineNum] ASC,
	[SecondaryNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S](
	[ExamNo] [varchar](20) NOT NULL,
	[SN] [varchar](100) NULL,
	[Sex] [char](1) NULL,
	[IDNo] [varchar](18) NULL,
	[Birthdate] [date] NULL,
	[Email] [varchar](100) NULL,
	[SNumber] [varchar](20) NULL,
	[EmergenNumber] [varchar](20) NULL,
	[SCategory] [varchar](50) NULL,
	[Province] [varchar](100) NULL,
	[UndergraSchool] [varchar](100) NULL,
	[DisType] [varchar](50) NULL,
	[UndergraMajor] [varchar](100) NULL,
	[UndergraTime] [date] NULL,
	[PreScores] [varchar](50) NULL,
	[SResume] [nvarchar](255) NULL,
	[fushi] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ExamNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SecDiscipline]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SecDiscipline](
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
	[PreSubjects] [varchar](255) NULL,
	[SecOverview] [nvarchar](255) NULL,
	[SecDisName] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[DisciplineNum] ASC,
	[SecondaryNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SecExam]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SecExam](
	[ExamNo] [varchar](255) NOT NULL,
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
	[Choice1] [varchar](255) NULL,
	[Choice2] [varchar](255) NULL,
	[Choice3] [varchar](255) NULL,
	[Direction] [varchar](255) NULL,
	[Adjust] [varchar](255) NULL,
	[Accept] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ExamNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SecS]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SecS](
	[ExamNo] [varchar](20) NOT NULL,
	[SecSN] [varchar](100) NULL,
	[Sex] [char](1) NULL,
	[SNumber] [varchar](20) NULL,
	[EmergenNumber] [varchar](20) NULL,
	[SCategory] [varchar](50) NULL,
	[UndergraSchool] [varchar](100) NULL,
	[UndergraTime] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ExamNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SecTInf]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SecTInf](
	[ExamNo] [varchar](20) NOT NULL,
	[SecScore] [decimal](5, 2) NULL,
	[SecTime] [datetime] NULL,
	[SecPlace] [varchar](255) NULL,
	[ProfTest] [decimal](5, 2) NULL,
	[Interview] [decimal](5, 2) NULL,
	[OverallScore] [decimal](5, 2) NULL,
	[LanguageScore] [decimal](5, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ExamNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentSelected]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentSelected](
	[ExamNo] [varchar](20) NOT NULL,
	[Selected] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ExamNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T](
	[TNo] [varchar](8) NOT NULL,
	[TN] [nvarchar](10) NOT NULL,
	[Title] [nvarchar](10) NOT NULL,
	[TImage] [varbinary](max) NULL,
	[TEmail] [varchar](20) NOT NULL,
	[TNumber] [varchar](11) NOT NULL,
	[TINTRO] [nvarchar](255) NULL,
 CONSTRAINT [T_Prim] PRIMARY KEY CLUSTERED 
(
	[TNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TeacherIndex]    Script Date: 2024/12/13 19:41:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TeacherIndex](
	[TNo] [varchar](8) NOT NULL,
	[TN] [nvarchar](10) NOT NULL,
	[DisciplineNum] [varchar](255) NOT NULL,
	[SecondaryNum] [varchar](255) NOT NULL,
	[IndexNo] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[TNo] ASC,
	[DisciplineNum] ASC,
	[SecondaryNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[IsSelected] ADD  DEFAULT ((0)) FOR [State]
GO
ALTER TABLE [dbo].[StudentSelected] ADD  DEFAULT ((0)) FOR [Selected]
GO
ALTER TABLE [dbo].[TeacherIndex] ADD  DEFAULT ((0)) FOR [IndexNo]
GO
ALTER TABLE [dbo].[Catalog]  WITH CHECK ADD FOREIGN KEY([DisciplineNum], [SecondaryNum])
REFERENCES [dbo].[SecDiscipline] ([DisciplineNum], [SecondaryNum])
GO
ALTER TABLE [dbo].[Catalog]  WITH CHECK ADD FOREIGN KEY([TNo])
REFERENCES [dbo].[T] ([TNo])
GO
ALTER TABLE [dbo].[IsSelected]  WITH CHECK ADD FOREIGN KEY([DisciplineNum], [SecondaryNum])
REFERENCES [dbo].[SecDiscipline] ([DisciplineNum], [SecondaryNum])
GO
ALTER TABLE [dbo].[Publicity]  WITH CHECK ADD FOREIGN KEY([DisciplineNum], [SecondaryNum])
REFERENCES [dbo].[SecDiscipline] ([DisciplineNum], [SecondaryNum])
GO
ALTER TABLE [dbo].[Publicity]  WITH CHECK ADD FOREIGN KEY([ExamNo])
REFERENCES [dbo].[S] ([ExamNo])
GO
ALTER TABLE [dbo].[Publicity]  WITH CHECK ADD FOREIGN KEY([TNo])
REFERENCES [dbo].[T] ([TNo])
GO
ALTER TABLE [dbo].[SecDiscipline]  WITH CHECK ADD FOREIGN KEY([DisciplineNum])
REFERENCES [dbo].[FirDiscipline] ([DisciplineNum])
GO
ALTER TABLE [dbo].[SecExam]  WITH CHECK ADD FOREIGN KEY([DisciplineNum], [SecondaryNum])
REFERENCES [dbo].[SecDiscipline] ([DisciplineNum], [SecondaryNum])
GO
ALTER TABLE [dbo].[SecS]  WITH CHECK ADD  CONSTRAINT [FK_SecS_S] FOREIGN KEY([ExamNo])
REFERENCES [dbo].[S] ([ExamNo])
GO
ALTER TABLE [dbo].[SecS] CHECK CONSTRAINT [FK_SecS_S]
GO
ALTER TABLE [dbo].[SecTInf]  WITH CHECK ADD  CONSTRAINT [FK_SecTInf_S] FOREIGN KEY([ExamNo])
REFERENCES [dbo].[S] ([ExamNo])
GO
ALTER TABLE [dbo].[SecTInf] CHECK CONSTRAINT [FK_SecTInf_S]
GO
ALTER TABLE [dbo].[StudentSelected]  WITH CHECK ADD FOREIGN KEY([ExamNo])
REFERENCES [dbo].[S] ([ExamNo])
GO
ALTER TABLE [dbo].[TeacherIndex]  WITH CHECK ADD FOREIGN KEY([TNo])
REFERENCES [dbo].[T] ([TNo])
GO
ALTER TABLE [dbo].[TeacherIndex]  WITH CHECK ADD FOREIGN KEY([DisciplineNum], [SecondaryNum])
REFERENCES [dbo].[SecDiscipline] ([DisciplineNum], [SecondaryNum])
GO
USE [master]
GO
ALTER DATABASE [newClassDesign] SET  READ_WRITE 
GO
